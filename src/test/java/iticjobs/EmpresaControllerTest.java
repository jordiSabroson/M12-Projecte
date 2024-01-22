package iticjobs;

import iticjobs.controller.EmpresaController;
import iticjobs.model.Empresa;
import iticjobs.repository.EmpresaRepository;
import iticjobs.repository.OfertaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class EmpresaControllerTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private OfertaRepository ofertaRepository;

    @InjectMocks
    private EmpresaController empresaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
    }

    @Test
    void buscaEmpresa() throws Exception {
        List<Empresa> empresas = List.of(new Empresa(), new Empresa());
        when(empresaRepository.findAll()).thenReturn(empresas);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/empresa"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(empresas.size()));

        verify(empresaRepository, times(1)).findAll();
    }

    @Test
    void buscaPerIdEmpresa() throws Exception {
        long id = 1L;
        Optional<Empresa> empresa = Optional.of(new Empresa());
        when(empresaRepository.findById(id)).thenReturn(empresa);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/empresa/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));

        verify(empresaRepository, times(1)).findById(id);
    }
}
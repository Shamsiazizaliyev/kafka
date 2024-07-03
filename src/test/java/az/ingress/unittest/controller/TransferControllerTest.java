package az.ingress.unittest.controller;

import az.ingress.unittest.dto.Transfer;
import az.ingress.unittest.service.TransferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransferController.class)
class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

     @MockBean
    private TransferService transferService;

    @Test
    void getTransfer() throws Exception {

        Transfer transfer=Transfer.builder().balance(300.00)
                        .name("shemsi")
                                .build();


        mockMvc.perform(
                        get("/transfer/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(transfer)))
                .andExpect(status().isOk());
    }

    @Test
    void postTransfer() throws  Exception {
        Transfer transfer=Transfer.builder().balance(300.00)
                .name("shemsi")
                .id(1L)
                .build();

        when(transferService.postTranfer(any(Transfer.class))).thenReturn(transfer);
        mockMvc.perform(post("/transfer")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(transfer)))
                .andExpect(jsonPath("$.name").value("shemsi"))
                .andExpect(status().isOk());


    }
}
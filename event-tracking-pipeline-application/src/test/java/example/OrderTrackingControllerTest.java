package example;

import com.example.OrderTrackingController;
import com.example.OrderTrackingExample;
import com.example.ServerBootstrap;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderTrackingController.class)
@ContextConfiguration(classes = ServerBootstrap.class)
class OrderTrackingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderTrackingExample orderTrackingExample;

    @Test
    void trackOrderStatusChangeShouldReturnOkAndInvokeService() throws Exception {
        mockMvc.perform(post("/api/order-tracking/status-change")
                        .param("orderId", "ORDER-10001")
                        .param("expressCode", "SF"))
                .andExpect(status().isOk())
                .andExpect(content().string("tracked"));

        Mockito.verify(orderTrackingExample)
                .trackOrderStatusChange("ORDER-10001", "SF");
    }

    @Test
    void trackOrderStatusChangeShouldReturnBadRequestWhenParamMissing() throws Exception {
        mockMvc.perform(post("/api/order-tracking/status-change")
                        .param("orderId", "ORDER-10001"))
                .andExpect(status().isBadRequest());
    }
}

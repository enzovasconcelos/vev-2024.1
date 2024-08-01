package services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.easymock.EasyMockSupport;
import static org.easymock.EasyMock.*;

public class IngressoServiceTests {

    private IngressoService ingressoService;
    ShowService showService;

    @BeforeAll
    static void Setup() {
        showService = mock(ShowService.class);
        ingressoService = new IngressoServiceImpl(showService);
    }

    @Test
    void venderIngresso() {
        // Arrange
        String idShow = "idTest1";
        Show showExpected = new Show(new Date(), "Test", 213.0, 200.0, false);
        expect(showService.getShow(idShow)).andReturn(showExpected); 
        replyAll();

        // Act
        String result = ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL);

        // Assert
        verifyAll();
        assertNotNull(result);
    }

    @Test
    void venderIngresso_ShouldThorwsException_When_idShowIsNull() {
        // Arrange
        String idShow = null;
        expect(showService.getShow(idShow)).andReturn(null); 
        replyAll();

        // Act & Assert
        verifyAll();
        assertThrowsException(Exception.class, () -> 
                              ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL))
    }

}

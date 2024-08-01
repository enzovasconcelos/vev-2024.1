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
        String idLote = "idLote";
        Show showExpected = new Show(new Date(), "Test", 213.0, 200.0, false);
        Lote loteExpected = new Lote(120, 0, 0.2);
        expect(showService.getShow(idShow)).andReturn(showExpected); 
        expect(loteService.getLote(idLote)).andReturn(loteExpected); 
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
        String idLote = "idLote";
        replyAll();

        // Act & Assert
        verifyAll();
        assertThrowsException(Exception.class, () -> 
                              ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL))
    }

    @Test
    void venderIngresso_ShouldThorwsException_When_idLoteIsNull() {
        // Arrange
        String idShow = "idTest1";
        String idLote = null;
        replyAll();

        // Act & Assert
        verifyAll();
        assertThrowsException(Exception.class, () -> 
                              ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL))
    }

}

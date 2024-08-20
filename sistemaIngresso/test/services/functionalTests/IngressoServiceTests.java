package services.functionalServices;

import static org.easymock.EasyMock.*;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.EasyMockRunner;
import org.easymock.TestSubject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import java.util.Date;
import entities.Show;
import entities.Ingresso;
import entities.Lote;
import services.LoteService;
import services.IngressoService;
import services.IngressoServiceImpl;
import services.ShowService;
import enums.TipoIngresso;

public class IngressoServiceTests {

    private IngressoService ingressoService;
    private LoteService loteService;
    private ShowService showService;

    @BeforeEach
    void setup() {
        showService = mock(ShowService.class);
        loteService = mock(LoteService.class);
        ingressoService = new IngressoServiceImpl(loteService, showService);
    }

    @Test
    void venderIngresso() {
        // Arrange
        String idShow = "idTest1";
        String idLote = "idLote";
        Show showExpected = new Show(new Date(), "Test", 213.0, 200.0, false);
        Lote loteExpected = new Lote(120, 0, 0.2f);
        assertNotNull(showService);
        assertNotNull(loteService);
        expect(showService.getShow(idShow)).andReturn(showExpected); 
        expect(loteService.getLote(idLote)).andReturn(loteExpected); 
        replay(showService);
        replay(loteService);

        // Act
        String result = ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL);

        // Assert
        assertNotNull(result);
    }

    @Test
    void venderIngresso_ShouldThorwsException_When_idShowIsNull() {
        // Arrange
        String idShow = null;
        String idLote = "idLote";

        // Act & Assert
        assertThrows(Exception.class, () -> 
                     ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL));
    }

    @Test
    void venderIngresso_ShouldThorwsException_When_idLoteIsNull() {
        // Arrange
        String idShow = "idTest1";
        String idLote = null;

        // Act & Assert
        assertThrows(Exception.class, () -> 
                     ingressoService.venderIngresso(idShow, idLote, TipoIngresso.NORMAL));
    }

}

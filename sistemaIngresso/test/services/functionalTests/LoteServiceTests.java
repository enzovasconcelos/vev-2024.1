package services.functionalServices;

import java.util.Date;
import static org.easymock.EasyMock.*;
import org.easymock.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import entities.Lote;
import entities.Show;
import entities.CreateShowRequest;
import services.ShowService;
import services.LoteService;
import services.LoteServiceImpl;
import repositories.LoteRepository;
import exceptions.ShowNotFoundException;

public class LoteServiceTests {

    private LoteService loteService;
    private ShowService showService;
    private LoteRepository loteRepository;

    @BeforeEach
    void setup() {
        showService = mock(ShowService.class);
        loteRepository = mock(LoteRepository.class);
        loteService = new LoteServiceImpl(loteRepository, showService);
    }

    @Test
    void criarLote_Deve_criarUmLote() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = 100;
        float desconto = 0.25f;
        float porcentagemVip = 0.2f;
        String idLote = "someId";
        Show showExpected = new Show(new Date(), "RC", 300, 300, false);
        expect(showService.getShow(showId)).andReturn(showExpected);
        Lote loteExpected = new Lote(idLote, numeroIngressos, desconto, porcentagemVip);
        expect(loteRepository.criarLote(anyObject(Lote.class))).andReturn(loteExpected); 
        showService.save(showExpected);
        replay(loteRepository);
        replay(showService);

        // Act
        Lote result = null;
        try {
             result = loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip);
        }
        catch (ShowNotFoundException e) {
            fail("Não deveria lançar exceção");
        }

        // Assert
        assertNotNull(result);
    }

    @Test
    void criarLote_Deve_LancarIllegalArgumentException_Quando_numeroIngresssENegativo() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = -100;
        float desconto = 0.25f;
        float porcentagemVip = 0.2f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip));
    }

    @Test
    void criarLote_Deve_LancarIllegalArgumentException_Quando_numeroIngressosEZero() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = 0;
        float desconto = 0.25f;
        float porcentagemVip = 0.2f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip));
    }

    @Test
    void criarLote_Deve_LancarIllegalArgumentException_Quando_descontoMaiorQue25() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = 100;
        float desconto = 0.26f;
        float porcentagemVip = 0.2f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip));
    }

    @Test
    void criarLote_Deve_LancarIllegalArgumentException_Quando_porcentagemVipForMenorQue20PorCento() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = 100;
        float desconto = 0.26f;
        float porcentagemVip = 0.199f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip));
    }

    @Test
    void criarLote_Deve_LancarIllegalArgumentException_Quando_porcentagemVipForMaiorQue30PorCento() {
        // Arrange
        String showId = "idShow";
        int numeroIngressos = 100;
        float desconto = 0.26f;
        float porcentagemVip = 0.31f;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            loteService.criarLote(showId, numeroIngressos, desconto, porcentagemVip));
    }

    // AVL
    @Test
    void getLote_Deve_LancarExcecao_Quando_loteIdForVazio() {
        // Arrange
        String idLote = "";
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
            loteService.getLote(idLote));
    }

    @Test
    void getLote_NaoDeve_LancarExcecao_Quando_loteIdTiverTamanhoUm() {
        // Arrange
        String idLote = "c";
        Lote loteExpected = new Lote(idLote, 200, 0.1f, 0.2f);
        expect(loteRepository.getLote(idLote)).andReturn(loteExpected);
        
        // Act
        Lote result = loteService.getLote(idLote);

        // Assert
        assertNotNull(result);
        assertTrue(loteExpected.equals(result));
    }

    @Test
    void getLote_Deve_RetornarLote() {
        // Arrange
        String idLote = "someId";
        Lote loteExpected = new Lote(idLote, 200, 0.1f, 0.2f);
        expect(loteRepository.getLote(idLote)).andReturn(loteExpected);
        
        // Act
        Lote result = loteService.getLote(idLote);

        // Assert
        assertNotNull(result);
        assertTrue(loteExpected.equals(result));
    }
}

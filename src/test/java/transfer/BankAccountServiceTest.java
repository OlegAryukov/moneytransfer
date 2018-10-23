package transfer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;
import ru.aryukov.revolut.dto.response.TransferResultResponse;
import ru.aryukov.revolut.modules.BaseModule;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.impl.BankAccountServiceImp;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankAccountServiceTest {
    Injector injector = Guice.createInjector(new BaseModule());
    BankAccountService bankAccountService = injector.getInstance(BankAccountServiceImp.class);

    @Test
    public void createAccountTest(){
        BankAccountDto bankAcc = (BankAccountDto) bankAccountService.createAccount(TestDataUtils.getBankAccPost());
        assertThat(bankAcc.getAmount(), is(TestDataUtils.getBankAccPost().getAmount()));
        assertThat(bankAcc.getUser().getId(), is(TestDataUtils.getBankAccPost().getUserId()));
        assertThat(bankAcc.getCurrencyType(), is(TestDataUtils.getBankAccPost().getCurrType()));
    }

    @Test
    public void transferTest(){
        //Создаем у пользователя с USD счетом еще один счет USD
        BankAccountDto bankAccountDto = (BankAccountDto)bankAccountService.createAccount(TestDataUtils.getBankAccPost());
        TransferPost tp = TestDataUtils.getTransferPost();
        tp.setBankAccIdDest(tp.getBankAccIdDest());
        //Делаем трансфер между счетами с одинаковой валютой
        TransferResultResponse responseEntity = (TransferResultResponse) bankAccountService.transfer(tp);
        assertThat(responseEntity.getMessage(), is("Transfer SUCCESS"));
    }

    @Test
    public void transferWithExchangeTest(){
        TransferPostWithExchange tp = TestDataUtils.getTransferPostWithExchange();
        //Делаем трансфер между счетами с разной валютой
        TransferResultResponse responseEntity = (TransferResultResponse) bankAccountService.transferWithExchange(tp);
        assertThat(responseEntity.getMessage(), is("Transfer SUCCESS"));
    }

    @Test
    public void transferWithNotEnoughMoneyTest(){
        //Создаем у пользователя с USD счетом еще один счет USD
        BankAccountDto bankAccountDto = (BankAccountDto) bankAccountService.createAccount(TestDataUtils.getBankAccPost());
        TransferPost tp = TestDataUtils.getTransferPost();
        tp.setSum(BigDecimal.valueOf(500));
        tp.setBankAccIdDest(bankAccountDto.getId());
        //Делаем трансфер между счетами с одинаковой валютой
        TransferResultResponse responseEntity = (TransferResultResponse) bankAccountService.transfer(tp);
        assertThat(responseEntity.getMessage(), is("Transfer NOT SUCCESS on account "
                + tp.getBankAccIdSource() + " not enough money"));
    }
}

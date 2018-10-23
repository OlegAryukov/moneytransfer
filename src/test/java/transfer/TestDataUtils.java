package transfer;


import ru.aryukov.revolut.dto.post.BankAccPost;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.UserPost;

import java.math.BigDecimal;

public class TestDataUtils {

    public static UserPost getUserPost(){
        return UserPost.builder()
                .name("Jhon")
                .secondName("Weak")
                .build();
    }

    public static BankAccPost getBankAccPost(){
        return BankAccPost.builder()
                .userId(1L)
                .amount(BigDecimal.valueOf(100))
                .currType("USD")
                .build();
    }

    public static TransferPost getTransferPost(){
        return TransferPost.builder()
                .bankAccIdSource(1l)
                .bankAccIdDest(4l)
                .sum(BigDecimal.valueOf(50))
                .build();
    }
}

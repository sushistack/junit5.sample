package samples.exception

import com.sushistack.BankAccount
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("BankAccount 클래스 테스트")
class BankAccountTest {

    @Nested
    @DisplayName("생성자 테스트")
    inner class ConstructorTests {

        @Test
        @DisplayName("초기 잔액이 양수일 때 정상적으로 객체 생성")
        fun `constructor with positive initial balance should create account`() {
            val account = BankAccount(100.0)
            assertThat(account.getBalance()).isEqualTo(100.0)
        }

        @Test
        @DisplayName("초기 잔액이 음수일 때 IllegalArgumentException 발생")
        fun `constructor with negative initial balance should throw IllegalArgumentException`() {
            assertThatExceptionOfType(IllegalArgumentException::class.java)
                .isThrownBy { BankAccount(-50.0) }
                .withMessage("초기 잔액은 음수가 될 수 없습니다.")
        }
    }

    @Nested
    @DisplayName("deposit 메서드 테스트")
    inner class DepositTests {

        @Test
        @DisplayName("유효한 금액을 입금할 때 잔액이 증가")
        fun `deposit valid amount should increase balance`() {
            val account = BankAccount(100.0)
            account.deposit(50.0)
            assertThat(account.getBalance()).isEqualTo(150.0)
        }

        @Test
        @DisplayName("0 이하의 금액을 입금할 때 IllegalArgumentException 발생")
        fun `deposit non-positive amount should throw IllegalArgumentException`() {
            val account = BankAccount(100.0)
            assertThatExceptionOfType(IllegalArgumentException::class.java)
                .isThrownBy { account.deposit(0.0) }
                .withMessage("입금액은 양수여야 합니다.")
        }
    }

    @Nested
    @DisplayName("withdraw 메서드 테스트")
    inner class WithdrawTests {

        @Test
        @DisplayName("유효한 금액을 출금할 때 잔액이 감소")
        fun `withdraw valid amount should decrease balance`() {
            val account = BankAccount(100.0)
            account.withdraw(50.0)
            assertThat(account.getBalance()).isEqualTo(50.0)
        }

        @Test
        @DisplayName("0 이하의 금액을 출금할 때 IllegalArgumentException 발생")
        fun `withdraw non-positive amount should throw IllegalArgumentException`() {
            val account = BankAccount(100.0)
            assertThatExceptionOfType(IllegalArgumentException::class.java)
                .isThrownBy { account.withdraw(-10.0) }
                .withMessage("출금액은 양수여야 합니다.")
        }

        @Test
        @DisplayName("잔액을 초과하여 출금할 때 IllegalStateException 발생")
        fun `withdraw exceeding balance should throw IllegalStateException`() {
            val account = BankAccount(100.0)
            assertThatExceptionOfType(IllegalStateException::class.java)
                .isThrownBy { account.withdraw(150.0) }
                .withMessage("잔액이 부족합니다.")
        }
    }
}
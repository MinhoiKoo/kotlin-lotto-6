package lotto

import lotto.domain.Lotto
import lotto.domain.NumberIssuer
import lotto.utils.Constant.LOTTO_NUMBER_SIZE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    fun `발행된 숫자 List의 size는 6이어야 한다`() {
        val numbers = NumberIssuer.issueNumbers()
        Assertions.assertThat(LOTTO_NUMBER_SIZE.equals(numbers.size))
    }

    @Test
    fun `발행된 숫자는 서로 다른 숫자여야 한다`() {
        val numbers = NumberIssuer.issueNumbers()
        Assertions.assertThat(numbers.size.equals(numbers.toSet().size))
    }

}

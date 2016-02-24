package uk.co.blackwells.shop.refund.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import uk.co.blackwells.shop.refund.entities.Refund;
import uk.co.blackwells.shop.refund.entities.Transaction;
import uk.co.blackwells.shop.refund.repository.RefundRepository;
import uk.co.blackwells.shop.refund.repository.TransactionRepository;
import uk.co.blackwells.shop.refund.service.impl.RefundServiceImpl;

/**
 * 
 * @author mikelimassol
 *
 */
public class RefundServiceTest {

	@InjectMocks
	RefundServiceImpl service = new RefundServiceImpl();

	@Mock
	private RefundRepository refundRepository;

	@Mock
	private TransactionRepository transactionRepository;

	/**
	 * 
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenRefundIsCalledAndAmountIsNull() {

		service.refund(null, null, null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenRefundIsCalledAndTransactionNotFound() {

		when(transactionRepository.getByRefId(Matchers.any(Long.class))).thenReturn(null);

		service.refund(1L, 1000D, "Test");

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenRefundIsCalledAndAmountNotEntitledToBeRefunded() {

		Double transactionAmount = 100D;
		Double existingRefundTotal = 100D;
		Double refundedAmount = 90D;

		Transaction transaction = new Transaction();
		transaction.setAmountPaid(transactionAmount);

		when(transactionRepository.getByRefId(Matchers.any(Long.class))).thenReturn(transaction);
		when(refundRepository.getRefundsTotalByRefId(Matchers.any(Long.class))).thenReturn(existingRefundTotal);

		service.refund(1L, refundedAmount, "Test");

		verify(transactionRepository, times(1)).getByRefId(Matchers.any(Long.class));
		verify(refundRepository, times(1)).getRefundsTotalByRefId(Matchers.any(Long.class));

	}

	@Test
	public void shouldReturnTrueWhenRefundIsCalled() {

		Double existingRefundTotal = 80D;
		Double refundedAmount = 20D;
		Double transactionAmount = 100D;

		Transaction transaction = new Transaction();
		transaction.setAmountPaid(transactionAmount);

		when(transactionRepository.getByRefId(Matchers.any(Long.class))).thenReturn(transaction);
		when(refundRepository.getRefundsTotalByRefId(Matchers.any(Long.class))).thenReturn(existingRefundTotal);

		assertTrue(service.refund(1L, refundedAmount, "Test"));

		verify(transactionRepository, times(1)).getByRefId(Matchers.any(Long.class));
		verify(refundRepository, times(1)).getRefundsTotalByRefId(Matchers.any(Long.class));
		verify(refundRepository, times(1)).insert(Matchers.any(Refund.class));

	}

	@Test
	public void shouldReturnFalseWhenRefundIsCalled() {

		Double existingRefundTotal = 80D;
		Double RefundedAmount = 30D;
		Double TransactionAmount = 100D;

		Transaction transaction = new Transaction();
		transaction.setAmountPaid(TransactionAmount);

		when(transactionRepository.getByRefId(Matchers.any(Long.class))).thenReturn(transaction);
		when(refundRepository.getRefundsTotalByRefId(Matchers.any(Long.class))).thenReturn(existingRefundTotal);

		assertFalse(service.refund(1L, RefundedAmount, "Test"));

		verify(transactionRepository, times(1)).getByRefId(Matchers.any(Long.class));
		verify(refundRepository, times(1)).getRefundsTotalByRefId(Matchers.any(Long.class));
		verify(refundRepository, times(0)).insert(Matchers.any(Refund.class));

	}

}

package org.example.bai01.logistics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ShippingFeeCalculatorTest {

    private final ShippingFeeCalculator calculator =
            new ShippingFeeCalculator();

    @Test
    void shouldCalculateFeeForWeightUnder1Kg() {
        double fee = calculator.calculateFee(1, 5);

        assertThat(fee).isEqualTo(50000);
    }

    @Test
    void shouldCalculateFeeForIntegerWeight() {
        double fee = calculator.calculateFee(3, 20);

        assertThat(fee).isEqualTo(170000);
    }

    @Test
    void shouldCalculateFeeForDecimalWeight() {
        double fee = calculator.calculateFee(1.5, 60);

        assertThat(fee).isEqualTo(350000);
    }

    @Test
    void shouldCalculateCorrectlyAt10Km() {
        double fee = calculator.calculateFee(1, 10);

        assertThat(fee).isEqualTo(100000);
    }

    @Test
    void shouldCalculateCorrectlyAt50Km() {
        double fee = calculator.calculateFee(1, 50);

        assertThat(fee).isEqualTo(300000);
    }

    @Test
    void shouldThrowExceptionWhenWeightInvalid() {
        assertThatThrownBy(() ->
                calculator.calculateFee(0, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionWhenDistanceInvalid() {
        assertThatThrownBy(() ->
                calculator.calculateFee(1, -5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
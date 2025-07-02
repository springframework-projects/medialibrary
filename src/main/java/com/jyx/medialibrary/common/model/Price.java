package com.jyx.medialibrary.common.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prices")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private BigDecimal value;

	@Column(nullable = false)
	private String currency;
	
	public Price(BigDecimal value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Price price = (Price) o;
		return Objects.equals(value, price.value) && Objects.equals(currency, price.currency);
	}

	// HashCode method
	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}

	// toString method
	@Override
	public String toString() {
		return "Price{" + "id=" + id + ", currency='" + currency + '\'' + ", value=" + value + '}';
	}

	
}
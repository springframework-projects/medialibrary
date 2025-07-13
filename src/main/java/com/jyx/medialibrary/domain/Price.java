//package com.jyx.medialibrary.domain;
//
//import java.math.BigDecimal;
//import java.util.Objects;
//import java.util.UUID;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Data
//@Slf4j
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "prices")
//public class Price {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.UUID)
//	private UUID id;
//
//	@Column(name = "amount", nullable = false)
//	private BigDecimal amount;
//
//	@Column(nullable = false)
//	private String currency;
//
//	public Price(BigDecimal amount, String currency) {
//		this.amount = amount;
//		this.currency = currency;
//	}
//
//
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		Price price = (Price) o;
//		return Objects.equals(amount, price.amount) && Objects.equals(currency, price.currency);
//	}
//
//	// HashCode method
//	@Override
//	public int hashCode() {
//		return Objects.hash(currency, amount);
//	}
//
//	// toString method
//	@Override
//	public String toString() {
//		return "Price{" + "id=" + id + ", currency='" + currency + '\'' + ", value=" + amount + '}';
//	}
//
//
//}
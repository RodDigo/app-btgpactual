package com.btgpactual.ordens.listener.dto;

import java.math.BigDecimal;

public record ItensEvent(String produto,Integer quantidade, BigDecimal valor) {

}

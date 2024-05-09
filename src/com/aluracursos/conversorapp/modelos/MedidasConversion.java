package com.aluracursos.conversorapp.modelos;

import java.util.List;

class MedidasConversion {
    public CodigoIsoMonedas medidasConversion;
}

class CodigoIsoMonedas {

    List<TazaCambio>    rates;
}


class TazaCambio {
    String currency;
    double rate;

    public TazaCambio(String currency, double rate) {
        this.currency = currency;
        this.rate     = rate;
    }
}
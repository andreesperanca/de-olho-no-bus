package com.andreesperanca.deolhonobus.mockdata

import com.andreesperanca.deolhonobus.models.BusRoute
import com.andreesperanca.deolhonobus.models.BusStop

class MockData {
    public val listLines = listOf<BusRoute>(
        BusRoute(1,
            true,
            "Cidade Alegria",
            "Campos Eliseos",
            1,
            "Cidade Alegria",
            "Campos Eliseos"),
    BusRoute(1,
    true,
    "Cidade Alegria",
    "Campos Eliseos",
    1,
    "Cidade Alegria",
    "Campos Eliseos"),
    BusRoute(1,
    true,
    "Cidade Alegria",
    "Campos Eliseos",
    1,
    "Cidade Alegria",
    "Campos Eliseos")
    )

    public val listBusStop = listOf<BusStop>(
        BusStop(1,
            "Parada da Alegria",
            "R ARMINDA/ R BALTHAZAR DA VEIGA",
            -23.592938,
            -46.672727),
        BusStop(1,
            "Parada da Alegria",
            "R ARMINDA/ R BALTHAZAR DA VEIGA",
            -23.592938,
            -46.672727),
        BusStop(1,
            "Parada da Alegria",
            "R ARMINDA/ R BALTHAZAR DA VEIGA",
            -23.592938,
            -46.672727),
    )

}
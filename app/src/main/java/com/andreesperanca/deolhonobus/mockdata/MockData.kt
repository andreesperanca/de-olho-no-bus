package com.andreesperanca.deolhonobus.mockdata

import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop

class MockData {
    public val listLines = listOf<BusLine>(
        BusLine(
            busLineNumber = 1,
            CircularRoute = true,
            firstLabel = "Cidade Alegria",
            secondLabel = "Campos Eliseos",
            direction = 1,
            mainTerminal = "Cidade Alegria",
            secondaryTerminal = "Campos Eliseos"),
        BusLine(
            busLineNumber = 1,
            CircularRoute = true,
            firstLabel = "Cidade Alegria",
            secondLabel = "Campos Eliseos",
            direction = 1,
            mainTerminal = "Cidade Alegria",
            secondaryTerminal = "Campos Eliseos"),
        BusLine(
            busLineNumber = 1,
            CircularRoute = true,
            firstLabel = "Cidade Alegria",
            secondLabel = "Campos Eliseos",
            direction = 1,
            mainTerminal = "Cidade Alegria",
            secondaryTerminal = "Campos Eliseos"),
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
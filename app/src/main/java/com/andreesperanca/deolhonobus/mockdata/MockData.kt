package com.andreesperanca.deolhonobus.mockdata

import com.andreesperanca.deolhonobus.models.BusLine
import com.andreesperanca.deolhonobus.models.BusStop
import com.andreesperanca.deolhonobus.models.Position
import com.andreesperanca.deolhonobus.models.Relations

class MockData {
    public val listLines = mutableListOf<BusLine>(
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

    public val listPosition = listOf(
        Position("12:45", listOf(
            Relations("aa",true, "12:43",
                -23.525799,
                -46.679251)
        ))
    )

}
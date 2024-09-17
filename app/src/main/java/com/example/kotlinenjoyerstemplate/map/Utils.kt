package com.example.kotlinenjoyerstemplate.map

import com.mapbox.geojson.Point

fun String.decodePolyline(): List<Point> {
    val coordinateChunks: MutableList<MutableList<Int>> = mutableListOf()
    coordinateChunks.add(mutableListOf())

    for (char in toCharArray()) {
        // convert each character to decimal from ascii
        var value = char.code - 63

        // values that have a chunk following have an extra 1 on the left
        val isLastOfChunk = (value and 0x20) == 0
        value = value and (0x1F)

        coordinateChunks.last().add(value)

        if (isLastOfChunk) coordinateChunks.add(mutableListOf())
    }

    coordinateChunks.removeAt(coordinateChunks.lastIndex)

    val coordinates: MutableList<Double> = mutableListOf()

    for (coordinateChunk in coordinateChunks) {
        var coordinate =
            coordinateChunk.mapIndexed { i, chunk -> chunk shl (i * 5) }.reduce { i, j -> i or j }

        // there is a 1 on the right if the coordinate is negative
        if (coordinate and 0x1 > 0) coordinate = (coordinate).inv()

        coordinate = coordinate shr 1
        coordinates.add((coordinate).toDouble() / 100000.0)
    }

    val points: MutableList<Point> = mutableListOf()
    var previousX = 0.0
    var previousY = 0.0

    for (i in 0..<coordinates.size step 2) {
        if (coordinates[i] == 0.0 && coordinates[i + 1] == 0.0) continue

        previousX += coordinates[i + 1]
        previousY += coordinates[i]

        points.add(Point.fromLngLat(previousX / 10, previousY / 10))
    }
    return points
}
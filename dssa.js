18 lines (18 sloc)  373 Bytes

class Bar {
    constructor(width, coordinateX) {
        this.width = width;
        this.coordinateX = coordinateX;
    }
    getWidth() {
        return this.width;
    }
    getCoordinateX() {
        return this.coordinateX;
    }
    setWidth(width) {
        this.width = width;
    }
    setCoordinateX(coordinateX) {
        this.coordinateX = coordinateX;
    }
}
package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;


public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(String
                    .format("Could not move by diagonal from %s to %s", position, dest));
        }
        int size = 1;
        Cell[] steps = new Cell[size];
        int deltaX = position().getX();
        int deltaY = position().getY();
        for (int index = 0; index < size; index++) {
            int x = index + deltaX;
            int y = index + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.getX() != dest.getX() && source.getY() != dest.getY()
                && Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY()) - dest.getY()) {
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

   /* public static void main(String[] args) throws ImpossibleMoveException {
        BishopBlack b = new BishopBlack(Cell.A1);
        System.out.println(b.position());
        System.out.println(b.copy(Cell.A1));
    }*/
}

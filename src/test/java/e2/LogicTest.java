package e2;
import e2.API.Logics;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  private static final int SIZE = 5;
  private static final Integer X_MOVE_KNIGHT = 2;
  private static final Integer Y_MOVE_KNIGHT = 1;

  private Logics logics;
  private Pair<Integer, Integer> pawn;
  private Pair<Integer, Integer> knight;

  private boolean isPosInMap(Pair<Integer, Integer> piece) {
    return piece.getX() >= 0 && piece.getX() < SIZE && piece.getY() >= 0 && piece.getY() < SIZE;
  }

  @BeforeEach
  void init() {
    this.logics = new LogicsImpl(SIZE);
    this.pawn = this.logics.getPawn();
    this.knight = this.logics.getKnight();
  }

  @Test
  void testInitialGridDimension() {
    assertEquals(SIZE, this.logics.getSize());
  }

  @Test
  void testHasPawn() {
    assertTrue(this.logics.hasPawn(this.pawn.getX(), this.pawn.getY()));
  }

  @Test
  void testHasKnight() {
    assertTrue(this.logics.hasKnight(this.knight.getX(), this.knight.getY()));
  }

  @Test
  void testInitialPositionOfPawnAndKnight() {
    assertAll(
            () -> assertNotNull(this.pawn),
            () -> assertNotNull(this.knight),
            () -> assertTrue(this.isPosInMap(this.pawn)),
            () -> assertTrue(this.isPosInMap(this.knight))
    );
  }

  @Test
  void testDifferentPositionsOfPawnAndKnight() {
    assertNotEquals(this.pawn, this.knight);
  }

  @Test
  void testKnightCanHitNewPos() {
    Pair<Integer, Integer> knight_new_pos = new Pair<>(
            this.knight.getX() + X_MOVE_KNIGHT,
            this.knight.getY() + Y_MOVE_KNIGHT);
    if(this.isPosInMap(knight_new_pos)) {
      if(knight_new_pos == this.pawn) {
        assertTrue(this.logics.hit(knight_new_pos.getX(), knight_new_pos.getY()));
      }
      assertAll(
              () -> assertFalse(this.logics.hit(knight_new_pos.getX(), knight_new_pos.getY())),
              () -> assertEquals(knight_new_pos, this.logics.getKnight())
      );
    } else {
      assertAll(
              () -> assertEquals(this.knight, this.logics.getKnight()),
              () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(knight_new_pos.getX(), knight_new_pos.getY()))
      );
    }
  }

  @Test
  void testKnightCannotDoInvalidMoveInBoard() {
    Pair<Integer, Integer> knight_new_pos = new Pair<>(
            this.knight.getX() + X_MOVE_KNIGHT,
            this.knight.getY() + X_MOVE_KNIGHT);
    if(this.isPosInMap(knight_new_pos)) {
      assertAll(
              () -> assertFalse(this.logics.hit(knight_new_pos.getX(), knight_new_pos.getY())),
              () -> assertEquals(this.knight, this.logics.getKnight())
      );
    } else {
      assertAll(
              () -> assertEquals(this.knight, this.logics.getKnight()),
              () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(knight_new_pos.getX(), knight_new_pos.getY()))
      );
    }
  }

  @Test
  void testKnightCannotMoveOutsideTheMap() {
    assertAll (
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(this.knight.getX() + SIZE, this.knight.getY())),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(this.knight.getX(), this.knight.getY() + SIZE)),
            () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(this.knight.getX() + SIZE, this.knight.getY() + SIZE))
    );
  }


}

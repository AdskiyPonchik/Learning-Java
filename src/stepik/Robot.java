package stepik;
//successfully solved
public class Robot {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        switch (direction) {
            case DOWN -> {
                this.direction = Direction.RIGHT;
                break;
            }
            case UP -> {
                this.direction = Direction.LEFT;
                break;
            }
            case LEFT -> {
                this.direction = Direction.DOWN;
                break;
            }
            case RIGHT -> {
                this.direction = Direction.UP;
                break;
            }
        }
    }

    @Deprecated //use instead turnRight
    public void turnRight_old() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    public void turnRight() {
        System.out.println("поворот по часовой стрелке");
        switch (direction) {
            case DOWN -> {
                this.direction = Direction.LEFT;
                break;
            }
            case UP -> {
                this.direction = Direction.RIGHT;
                break;
            }
            case LEFT -> {
                this.direction = Direction.UP;
                break;
            }
            case RIGHT -> {
                this.direction = Direction.DOWN;
                break;
            }
        }
    }

    public void stepForward() {
        System.out.println("движение");
        switch (direction) {
            case DOWN -> this.y--;
            case UP -> this.y++;
            case LEFT -> this.x--;
            case RIGHT -> this.x++;
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) robot.turnRight();
            while (robot.getX() < toX) robot.stepForward();
        } else if (robot.getX() > toX) {
            while(robot.getDirection() != Direction.LEFT) robot.turnLeft();
            while(robot.getX() > toX) robot.stepForward();
        }
        if(robot.getY() < toY) {
            while(robot.getDirection()!=Direction.UP)robot.turnRight();
            while(robot.getY() < toY) robot.stepForward();
        }
        else if(robot.getY() > toY) {
            while(robot.getDirection()!=Direction.DOWN)robot.turnLeft();
            while(robot.getY() > toY) robot.stepForward();
        }
    }
}
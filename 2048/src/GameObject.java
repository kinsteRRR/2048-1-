import java.util.Random;

public class GameObject {

    public double x, y;
    public int width, height;
    public Kaka kaka;
    public int value, speed = 8;
    public boolean moving = false, remove = false, hasMoved = false;

    Random rand = new Random();

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.value = (rand.nextBoolean() ? 2 : 4);
        createSprite();
        this.width = Kaka.width;
        this.height =Kaka.height;
    }

    public void createSprite() {
        if(this.value == 2) {
            this.kaka = new Kaka(100, 100, 0xefe5db);
        }else if(this.value == 4) {
            this.kaka = new Kaka(100, 100, 0xece0c8);
        }else if(this.value == 8) {
            this.kaka = new Kaka(100, 100, 0xf1b078);
        }else if(this.value == 16) {
            this.kaka = new Kaka(100, 100, 0xEB8C52);
        }else if(this.value == 32) {
            this.kaka = new Kaka(100, 100, 0xF57C5F);
        }else if(this.value == 64) {
            this.kaka = new Kaka(100, 100, 0xEC563D);
        }else if(this.value == 128) {
            this.kaka = new Kaka(100, 100, 0xF2D86A);
        }else if(this.value == 256) {
            this.kaka = new Kaka(100, 100, 0xECC750);
        }else if(this.value == 512) {
            this.kaka = new Kaka(100, 100, 0xE5BF2D);
        }else if(this.value == 1024) {
            this.kaka = new Kaka(100, 100, 0xE2B913);
        }else if(this.value == 2048) {
            this.kaka = new Kaka(100, 100, 0xEDC22E);
        }else if(this.value == 4096) {
            this.kaka = new Kaka(100, 100, 0x5DDB92);
        }else if(this.value == 8192) {
            this.kaka = new Kaka(100, 100, 0xEC4D58);
        }
    }

    public boolean canMove() {
        if(x < 0 || x + width > Main.WIDTH || y < 0 || y + height > Main.HEIGHT) {
            return false;
        }
        for(int i = 0; i < Game.objects.size(); i++) {
            GameObject o = Game.objects.get(i);
            if(this == o) continue;
            if(x + width > o.x && x < o.x + o.width && y + height > o.y && y < o.y + o.height && value != o.value) {
                return false;
            }
        }
        return true;
    }

    public void update() {
        if(Game.moving) {
            if(!hasMoved) {
                hasMoved = true;
            }
            if(canMove()) {
                moving = true;
            }

            if(moving) {
                if(Game.dir == 0) x -= speed;
                if(Game.dir == 1) x += speed;
                if(Game.dir == 2) y -= speed;
                if(Game.dir == 3) y += speed;
            }
            if(!canMove()) {
                moving = false;
                x = Math.round(x / 100) * 100;
                y = Math.round(y / 100) * 100;
            }
        }

    }

    public void render() {
        Renderer.renderKaka(kaka, (int) x, (int) y);
    }
}

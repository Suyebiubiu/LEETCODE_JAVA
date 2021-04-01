package cn.swordOffer.baidu;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/27 16:34
 * 线程安全，双层加锁
 */
public class DanLiMoShi {
    private static DanLiMoShi instance;

    private DanLiMoShi() {
    }

    public synchronized static DanLiMoShi getInstance() {
        if (instance == null) {
            synchronized (DanLiMoShi.class) {
                if (instance == null) instance = new DanLiMoShi();
            }
        }
        return instance;
    }
}

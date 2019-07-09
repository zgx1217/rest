package aaa.tenancy.common;



/**
 * 公共service实现
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements  BaseService<T> {

    protected abstract BaseDao<T> getDao();
    @Override
    public int save(T t) {
        return  getDao().save(t);
    }

    @Override
    public DefaultMsg delete(T t) {
        DefaultMsg dm = new DefaultMsg();
        int count = getDao().delete(t);
        if(count==0){
            dm.setSuccess(0);
            dm.setError("删除失败");
        }
        return dm;
    }

    @Override
    public int update(T t) {
        return getDao().update(t);
    }

    @Override
    public T findById(Long id) {
        return getDao().findById(id);
    }
}

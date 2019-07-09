package aaa.tenancy.common;

/**
 * 公共service接口
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 保存实体
     * @param t
     * @return
     */
    public int save(T t);

    /**
     * 删除实体
     * @param t
     * @return
     */
    public DefaultMsg delete(T t);


    /**
     * 修改实体
     * @param t
     * @return
     */
    public int update(T t);

    /**
     * 根据主键查询对象
     * @param id
     * @return
     */
    public T findById(Long id);
}

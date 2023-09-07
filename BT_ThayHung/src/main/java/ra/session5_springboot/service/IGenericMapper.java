package ra.session5_springboot.service;

public interface IGenericMapper<T,K,V>{
    T toEntity(K k);
    V toResponse(T t);
}

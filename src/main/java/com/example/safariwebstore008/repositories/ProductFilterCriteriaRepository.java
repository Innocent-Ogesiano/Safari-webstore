package com.example.safariwebstore008.repositories;


import com.example.safariwebstore008.models.Product;
import com.example.safariwebstore008.models.ProductPage;
import com.example.safariwebstore008.models.ProductSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductFilterCriteriaRepository {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public ProductFilterCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();

    }

    public Page<Product> findAllProductWithFilter(ProductPage myProductPage,
                                                   ProductSearchCriteria myProductSearchCriteria){
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> myProductRoot = criteriaQuery.from(Product.class);
        Predicate predicate = getPredicate(myProductSearchCriteria,
          myProductRoot);
        criteriaQuery.where(predicate);
        setOrder(myProductPage, criteriaQuery, myProductRoot);
        TypedQuery<Product> typedQuery = entityManager.
                createQuery(criteriaQuery);
        typedQuery.setFirstResult(myProductPage.getPageNumber() * myProductPage.getPageSize());
        typedQuery.setMaxResults(myProductPage.getPageSize());
        Pageable pageable = getPageable(myProductPage);
        long myProductCount = getMyProduct(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, myProductCount);
    }



    private Predicate getPredicate(ProductSearchCriteria myProductSearchCriteria,
                                   Root<Product> myProductRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(myProductSearchCriteria.getSubCategory())){
              predicates.add(criteriaBuilder.like(myProductRoot.get("subCategory"), "%" + myProductSearchCriteria.getSubCategory() + "%"));

        }
          if(Objects.nonNull(myProductSearchCriteria.getSize())){
            predicates.add(criteriaBuilder.like(myProductRoot.get("size"), "%" + myProductSearchCriteria.getSize() + "%" ));

        }
          if(Objects.nonNull(myProductSearchCriteria.getPrice())){
            predicates.add(criteriaBuilder.like(myProductRoot.get("price"), "%" + myProductSearchCriteria.getPrice() + "%" ));

        }
          if(Objects.nonNull(myProductSearchCriteria.getColor())){
            predicates.add(criteriaBuilder.like(myProductRoot.get("name"), "%" + myProductSearchCriteria.getColor() + "%" ));

        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

    private void setOrder(ProductPage myProductPage,
                          CriteriaQuery<Product> criteriaQuery,
                          Root<Product> myProductRoot) {
        if (myProductPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.
                    asc(myProductRoot.get(myProductPage.getSortBy())));
        }else {
            criteriaQuery.orderBy(criteriaBuilder.
                    desc(myProductRoot.get(myProductPage.getSortBy())));
        }
    }

    private Pageable getPageable(ProductPage myProductPage) {
        Sort sort = Sort.by(myProductPage.getSortDirection(), myProductPage.getSortBy());
        return PageRequest.of(myProductPage.getPageNumber(), myProductPage.getPageSize(), sort);
    }

    private long getMyProduct(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.
                createQuery(long.class);
        Root<Product> countRoot = countQuery.from(Product.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();

    }

}

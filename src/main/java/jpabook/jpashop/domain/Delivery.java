package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    //ORDINAL는 ENUM 타입을 0,1,2 순서처럼 숫자형태로 저장해줘서 중간에 다른 값을 넣으면 바뀌므로 사용 X
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY, COMP
}

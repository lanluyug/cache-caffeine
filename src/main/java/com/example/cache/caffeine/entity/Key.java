package com.example.cache.caffeine.entity;

import lombok.Data;


/**
 * @Data相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的合集
 */
@Data
public class Key{
    String name;
    long timestamp;
}

package cn.com.bluemoon.bd.webmagiclearning.spring.event;

import lombok.*;

import java.io.Serializable;

/**
 * <b><code>User</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/9/11.
 *
 * @author dengzhen
 * @since webmagic-learning
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable {
    
    private static final long serialVersionUID = -7217433613461295244L;
    
    private String userName;
    private String password;
}

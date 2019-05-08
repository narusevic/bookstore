/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOOK")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title LIKE :title"),
    @NamedQuery(name = "Book.findByWriterId", query = "SELECT b FROM Book b WHERE b.writerId LIKE :writerId")
})
@Getter
@Setter
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 3, max = 20)
    @Column(name = "Title")
    private String title;

    @JoinColumn(name = "WRITER_ID", referencedColumnName = "ID")
    @ManyToOne
    @JohnzonIgnore
    private Writer writer;

}

package com.example.annotation.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.annotation.demo.request.PlayerNameDto;
import com.example.annotation.demo.request.PlayerStateDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chess_player")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedNativeQuery(name = "ChessPlayer.findPlayerNameDtoById_Named", 
                  query = "select c.first_name as first, c.last_name as last,c.id as Id from chess_player c where c.id=:id", 
                  resultSetMapping = "Mapping.PlayerNameDto")
@SqlResultSetMapping(name = "Mapping.PlayerNameDto", 
                      classes = @ConstructorResult(targetClass = PlayerNameDto.class, 
                                                       columns = {@ColumnResult(name = "first"), 
                                                    		      @ColumnResult(name = "last"),
                                                    		      @ColumnResult(name = "Id")}))

@NamedNativeQuery(name="ChessPlayer.findByPlayerAndStateDetails",
                  query = "select c.first_name as firstName,c.last_name as lastName,c.team_name as teamName,s.board_name as boardName,"
                  		+ "s.state,s.player_id as playerId from chess_player c inner join state_chess_board s on c.id=s.player_id where "
                  		+ "c.id=:id",
                  resultSetMapping = "Mapping.PlayerStateDto")
@SqlResultSetMapping(name="Mapping.PlayerStateDto",classes = @ConstructorResult(targetClass = PlayerStateDto.class,
                                                                                 columns = {@ColumnResult(name="firstName"),
                                                                                		    @ColumnResult(name="lastName"),
                                                                                		     @ColumnResult(name="boardName"),
                                                                                		     @ColumnResult(name="playerId"),
                                                                                		     @ColumnResult(name="state"),
                                                                                		     @ColumnResult(name="teamName")}))

@SqlResultSetMapping(name="ChessPlayerMapping",entities = {@EntityResult(entityClass = ChessPlayer.class,
                                                       fields = {
                                                    		   @FieldResult(name="id",column = "Id"),
                                                    		   @FieldResult(name="firstName",column = "firstName"),
                                                    		   @FieldResult(name="lastName",column = "lastName"),
                                                    		   @FieldResult(name="teamName",column = "teamName")
                                                    		   })})


@NamedNativeQuery(name = "ChessPlayer.getChessPlayerByLastName", 
                    query = "select * from chess_player c where c.team_name=:lastName", 
                    resultClass = ChessPlayer.class)
@NamedNativeQuery(name = "ChessPlayer.getChessPlayerByLastName.count", 
                    query = "select count(id) from chess_player c where c.team_name=:lastName")

public class ChessPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String lastName;
	private String teamName;
	private Date date;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="player_id",referencedColumnName = "id") // here referencedColumnName id is ChessPlayer primaryKey id as referring as forigen key of StateBoard table
	private Set<StateBoard> stateBoard;

}

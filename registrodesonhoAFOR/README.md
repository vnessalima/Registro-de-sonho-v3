```mermaid
 classDiagram
    Usuario "1" -- "1..*" Sonho 
    Historico "1" -- "1..*" Sonho 

class Usuario {
    -id: Integer
    -nome: String
    -login: String
    -email: String
    +getId():Long
    +setId(id:Long):void
    +getNome(): String
    +setNome(nome: String):void
    +getLogin(): String
    +setLogin(login: String): void
    +toString(): String
    +getEmail(): Object
    +setEmail(email: String): void

}

class Sonho {
    -id: Integer
    -descricao: String
    -emocao: String
    -data: Date
    +getId(): Integer
    +setId(id: Integer): void
    +getTema(): String
    +setTema(tema: String): void
    +getDescricao(): String
    +setDescricao(descricao: String): void
    +getEmocao(): String
    +setEmocao(emocao: String): void
    +getData(): Date
    +setData(data: Date): void
}

class Historico {
    -id: Integer
    -usuario: Usuario
    +getId(): Long
    +setId(id: Long): void
    +getUsuario(): Usuario
    +getUsuario(usuario: Usuario): Void
    +getSonhos(): Sonho[*]
    +seetSonhos(sonhos: Sonho[*]): void
}

  ```
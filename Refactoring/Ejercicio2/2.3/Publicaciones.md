# 2.3 Publicaciones
![image](https://github.com/Ruyy7/OO2/assets/87097965/76a89993-1dbb-4fe5-a18f-28d69187c091)

### Clase PostApp
```java
public class PostApp{
        private List<Post> post;
        /**
        * Retorna los últimos N posts que no pertenecen al usuario user
        */
        public List<Post> ultimosPosts(Usuario user, int cantidad) {
            List<Post> postsOtrosUsuarios = new ArrayList<Post>();
            for (Post post : this.posts) {
                if (!post.getUsuario().equals(user)) {
                    postsOtrosUsuarios.add(post);
                }
            }
                
           // ordena los posts por fecha
           for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
               int masNuevo = i;
               for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
                   if (postsOtrosUsuarios.get(j).getFecha().isAfter(
             postsOtrosUsuarios.get(masNuevo).getFecha())) {
                      masNuevo = j;
                   }    
               }
              Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
              postsOtrosUsuarios.set(masNuevo, unPost);    
           }
                
            List<Post> ultimosPosts = new ArrayList<Post>();
            int index = 0;
            Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
            while (postIterator.hasNext() &&  index < cantidad) {
                ultimosPosts.add(postIterator.next());
            }
            return ultimosPosts;
        }
}
```
(i) El nombre del método no describe con exactitud lo que realiza.
(ii) Rename method.

### Clase PostApp
```java
public class PostApp{
        private List<Post> post;
        /**
        * Retorna los últimos N posts que no pertenecen al usuario user
        */
        public List<Post> ultimosNPostsExcluendoUsuario(Usuario user, int cantidad) {
            List<Post> postsOtrosUsuarios = new ArrayList<Post>();
            for (Post post : this.posts) {
                if (!post.getUsuario().equals(user)) {
                    postsOtrosUsuarios.add(post);
                }
            }
                
           // ordena los posts por fecha
           for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
               int masNuevo = i;
               for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
                   if (postsOtrosUsuarios.get(j).getFecha().isAfter(
             postsOtrosUsuarios.get(masNuevo).getFecha())) {
                      masNuevo = j;
                   }    
               }
              Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
              postsOtrosUsuarios.set(masNuevo, unPost);    
           }
                
            List<Post> ultimosPosts = new ArrayList<Post>();
            int index = 0;
            Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
            while (postIterator.hasNext() &&  index < cantidad) {
                ultimosPosts.add(postIterator.next());
            }
            return ultimosPosts;
        }
}
```

(i) Longh method.

(ii) Exctract method. Fragmentos de código que pueden ser reagrupados.

Podemos separarlo en 3 métodos mas especializados en una tarea.
- Excluir usuario en coleccion
- Ordenar por fecha
- Ultimos N post

### Clase PostApp
```java
public class PostApp{
        private List<Post> post;
        public List<Post> postExcluyendoUsuario(Usuario user) {
            List<Post> postsOtrosUsuarios = new ArrayList<Post>();
            for (Post post : this.posts) {
                if (!post.getUsuario().equals(user)) {
                    postsOtrosUsuarios.add(post);
                }
            }
        }    
        public List<Post> postOrdenadosPorFecha(List<Post> listaPost){
                for (int i = 0; i < listaPost.size(); i++) {
                int masNuevo = i;
                for(int j= i +1; j < listaPost.size(); j++) {
                   if (listaPost.get(j).getFecha().isAfter(
                listaPost.get(masNuevo).getFecha())) {
                      masNuevo = j;
                   }    
                }
                Post unPost = listaPost.set(i,listaPost.get(masNuevo));
                listaPost.set(masNuevo, unPost);    
                }
                return listaPost;
        }
        public List<Post> ultimosNPost(List<Post> listaPost, int cantidad)  
            List<Post> ultimosPosts = new ArrayList<Post>();
            int index = 0;
            Iterator<Post> postIterator = listaPost.iterator();
            while (listaPost.hasNext() &&  index < cantidad) {
                ultimosPosts.add(postIterator.next());
                index++;
            }
            return ultimosPosts;
        }
}
```
(i) Usos de for para cada vez que se necesita recorrer una colección.

(ii) Replace loop with pipeline. Los streams son una manera mas legible y eficiente de recorrer colecciones.
- Las variables temporales se eliminan.
- Varias lineas de código son remplazadas por el pipeline adecuado.

### Clase PostApp
```java
public class PostApp{
        private List<Post> post;
        public List<Post> postExcluyendoUsuario(Usuario user) {
                return this.post.stream().filter (post -> !post.getUsuario().equals(user)).collect(Collectors.toList());
        }
   
        public List<Post> postOrdenadosPorFecha(List<Post> listaPost){
                return listaPost.stream().sorted((post1,post2) -> post2.getFecha().compareTo(post1.getFecha())).collect(Collectors.toList());
        }

        public List<Post> ultimosNPost(List<Post> listaPost, int cantidad)  
            return listaPost.stream().limit(cantidad)collect(Collectors.toList());
        }
}
```
(i) Responsabilidad mal asignada. El post debe saber si el usuario es perteneciente del mismo o no, en vez de que la app pregunte por equals. Feature envy.

(ii) Move method. Es el post quien sabra determinar si un usuario es perteneciente del mismo.

### Clase PostApp
```java
public class PostApp{
        private List<Post> post;
        public List<Post> postExcluyendoUsuario(Usuario user) {
                return this.post.stream().filter (post -> post.perteneceAotroUser.(user)).collect(Collectors.toList());
        }
   
        public List<Post> postOrdenadosPorFecha(List<Post> listaPost){
                return listaPost.stream().sorted((post1,post2) -> post2.getFecha().compareTo(post1.getFecha())).collect(Collectors.toList());
        }

        public List<Post> ultimosNPost(List<Post> listaPost, int cantidad)  
            return listaPost.stream().limit(cantidad)collect(Collectors.toList());
        }
}
```

### Clase Post
```java
public class Post{
        private String texto;
        private LocalDateTime fecha;
        private Usuario usuario;

        public Post (String texto, Usuario usuario){
                this.texto = texto;
                this.usuario = usuario;
                this.fehca = LocalDateTime.now();
        }

        public Usuario getUsuario(){
                return this.usuario;
        }
        public LocalDateTime getFecha(){
                return this.fecha;
        }

        public boolean perteneceAotroUser (Usuario user){
                return !this.usuario.equals(user);
        }
}
```

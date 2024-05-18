![image](https://github.com/Ruyy7/OO2/assets/87097965/76a89993-1dbb-4fe5-a18f-28d69187c091)

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

```java
public class PostApp{
        private List<Post> post;
        public List<Post> postExcluyendoUsuario(Usuario user) {
                return this.post.stream().filter (post -> !post.getUsuario.(user)).collect(Collectors.toList());
        }
   
        public List<Post> postOrdenadosPorFecha(List<Post> listaPost){
                return listaPost.stream().sorted((post1,post2) -> post2.getFecha().compareTo(post1.getFecha())).collect(Collectors.toList());
        }

        public List<Post> ultimosNPost(List<Post> listaPost, int cantidad)  
            return listaPost.stream().limit(cantidad)collect(Collectors.toList());
        }
}
```

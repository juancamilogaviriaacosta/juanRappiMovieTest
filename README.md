# juanRappiMovieTest

La aplicación cuenta con 4 capas

Vistas: Controladores de cada vista
AboutActivity
MainActivity
MovieAdapter
MovieDetailActivity
PopularActivity
SearchActivity
TopratedActivity
UpcomingActivity

Modelos: Representación y mapeo POJO de los objetos devueltos por el web service
MovieDBResult
Result

Red: Hilos que se encargan de hacer las peticiones al web service y actualizar las vista
MovieDBThread
DownloadImageThread

Utilidades: Clase con métodos estáticos utilitarios
Utilidades


El principio de responsabilidad única busca hacer las clases menos sensibles a los cambios y del mismo modo reducir el acoplamiento entre las mismas. Para lograrlo es necesario que cada clase se encargue  (en lo posible) de una sola funcionalidad de la aplicación.

Un código limpio debe ser fácil de leer y por lo tanto de mantener, para esto se aplican diferentes técnicas, por ejemplo evitar la redundancia (no copiar y pegar código), utilizar nombres descriptivos de variables, hacer pruebas unitarias, entre otros

# Bookpedia
Proyecto Final Aplicaciones Móviles con Android Studio y Kotlin

»Terminado diseño y funcionalidad de Barra lateral.
»Terminado diseño de Item para el RecyclerView

»Trabajando en Funcionalidad de RecyclerView


#Bitacora de Hallazgos:
Codificando el RecyclerView En el main activity (En el cual ya está el código del NavigatorView) Causa que solo se vea el RecyclerView, desapareciendo la barra de navegación lateral.
» Pasamos el Recycler view a un fragmento. Pero la forma en que funcionan los fragmentos es diferente a la forma en que funcionan los Activitys. La palabra reservada this daba problemas en el fragment. La remplasamos con requireContext(). Esto solucionó el problema, pero ahora el código crashea cuando queremos definir el recyclerView como binding.recyclerViewFragment.
Una forma de eludir este crasheo fue agregando la siguiente instrucción:
binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
Antes de comenzar a trabajar con el binding. Pero ahora el crasheo se trasladó a return binding.recyclerViewFragment.

Si cambiamos binding.root. Se evita el crasheo. Pero terminamos en la misma circunstancia del comienzo. Solo mostrando el RecyclerView

Para eludir el solucionar el problema analizaremos los ejemplos de plantillas ya hechas por android studio, Utilizaremos la de la barra lateral, y la que contiene el recyclerview en conjunto con los fragments. Para esto habrá que cambiar en este ultimo la barra de navegación inferior, por la barra de navegación lateral. 
Una fusionadas ambas plantillas en nuestro proyecto podremos continuar con su desarrollo

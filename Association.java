/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764 
 * @description Clase cuya funcion es agrupar las palabras del diccionario, la clave
 * es la palabra en ingles y el valor es la palabra en español
 * @date última modificación 18/03/2024
 */
    public class Association<K,V> {
        private K key;
        private V value;

        public Association(K key, V value) {
            this.key = key;
            this.value = value;
        }


        /** 
         * @return E
         */
        public K getKey() {
            return key;
        }

        /** 
         * @param key
         */
        public void setKey(K key) {
            this.key = key;
        }

        /** 
         * @return V
         */
        public V getValue() {
            return value;
        }

        /** 
         * @param value
         */
        public void setValue(V value) {
            this.value = value;
        }
    }

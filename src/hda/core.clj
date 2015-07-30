(ns hda.core
  (:require [instaparse.core :as insta])
  (:require [clojure.pprint :as pp])
  (:gen-class
      :name me.krismade.ucm.HdaParser
      :methods [#^{static :true} [parseProps [String] clojure.lang.PersistentVector]]))

(def parser-props
  (insta/parser
   "<properties>  = prop-header prop-body <prop-end>
    prop-header = <'@Properties'> <whitespace> name <newline>
    <prop-body> = (property <newline>)+
    prop-end    = '@end' <newline>*
    property    = pname <equals> value
    pname       = #'[a-zA-Z]+'
    equals      = '='
    value       = number | string
    <string>    = (pchar+ whitespace*)+
    <pchar>     = #'[a-zA-Z0-9\\'\\[\\]\\{\\},.!/:-]+'
    name        = #'[a-zA-Z]+'
    <whitespace>= #'\\s+'
    <newline>   = #'\\n'
    number      = #'[0-9]+'"))

(def hda-transform-opt
  {:number read-string
   :value str
   :pname read-string
   :property #(vector (keyword %1) %2)q
   ;; :properties (let []
   ;;               (comp (partial into {}) vector))
   })

(defn parse-props [input]
  (->> (parser-props input)
       (insta/transform hda-transform-opt)))

(defn -parseProps [input]
  (parse-props input))


(defn blah [p]
  (loop [l p]
    (when-let [[h t] (first l)]
      (recur (rest l)))
    ))

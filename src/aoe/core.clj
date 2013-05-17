(ns aoe.core
  (:use [clojure.string :only [upper-case]])
  (:require [aoe.dict]))

(defmulti pinyin type)
(defmethod pinyin String [s] (map pinyin s))
(defmethod pinyin Character [c]
  (let [hex (upper-case (Integer/toHexString (int c)))]
    (aoe.dict/dict hex)))

(ns aoe.dict
  (:require [clojure.java.io :as io]))

(defn- sbutlast
  [n ^String s]
  (if (< (count s) n)
    ""
    (.substring s 0 (- (count s) n))))

(defn- slast [^String s]
  (if (= (count s) 0)
    ""
    (let [c (count s)]
      (.substring s (- c 1) c))))

(def dict
  (with-open [rdr (io/reader (.openStream (io/resource "unicode_to_hanyu_pinyin.txt")))]
    (into {}
      (for [line (line-seq rdr)
            :let [[code, pinyin-str] (.split line " ")
                  items (map #(identity {:pinyin (sbutlast 1 %1) :tone (Integer/parseInt (slast %1))}) (.split pinyin-str ", *")) ]]
        [code items]))))


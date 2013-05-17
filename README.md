# aoe

A Clojure library designed to convert chinese to pinyin.

## Usage

```clojure
(use 'aoe.core)

(pinyin \赵) ; => ({:pinyin "zhao", :tone 4})
(pinyin "赵耀") ; => (({:pinyin "zhao", :tone 4}) ({:pinyin "yao", :tone 4} {:pinyin "yue", :tone 4}))
```

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.

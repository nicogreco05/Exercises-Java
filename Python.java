/*
import re
from enum import Enum
from abc import ABC, abstractclass

class Titolo:
     def __init__(self, titolo : str):
         if not titolo:
            Raise Exception("Titolo nullo")
         if not re.matches(r"",titolo):
            Raise Exception("Titolo non valido")
         self._titolo = titolo

     def __str__(self):
         return self._titolo

     def __eq__(self, other):
         if not instanceof(other, Titolo):
            return false
         return self._titolo = other._titolo

class Anno:
      def __init__(self, val: int):
          if not (1453 <= val <= 2100):
             Raise Exception("Valore non valido")
          self._val = val

      def __str__(self):
             return self._titolo

      def __eq__(self, other):
            if not instanceof(other, Titolo):
            return false
            return self._titolo = other._titolo

continuano...

class Supporto(ABC):
      @abstractmethod
      def getTitolo(self): -> Titolo: pass
      @abstractmethod
      def getAnnoEdizione(self): -> Anno: pass

continuano...

class GeneriCD(Enum):
      rock : 1
      pop : 2
      classica : 3

continuano...
*/





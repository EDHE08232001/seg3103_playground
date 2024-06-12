# tests/test_calculator.py

import unittest
from src.calculator import Calculator

class TestCalculator(unittest.TestCase):

    def setUp(self):
        self.calc = Calculator()

    def test_add(self):
        self.assertEqual(self.calc.add(1, 2), 2)
        self.assertEqual(self.calc.add(-1, -1), -1)
        self.assertEqual(self.calc.add(-1, 1), 0)

    def test_subtract(self):
        self.assertEqual(self.calc.subtract(2, 1), 1)
        self.assertEqual(self.calc.subtract(-1, -1), 0)
        self.assertEqual(self.calc.subtract(-1, 1), -2)

    def test_multiply(self):
        self.assertEqual(self.calc.multiply(2, 3), 6)
        self.assertEqual(self.calc.multiply(-1, -1), 1)
        self.assertEqual(self.calc.multiply(-1, 1), -1)

    def test_divide(self):
        self.assertEqual(self.calc.divide(6, 3), 2)
        self.assertEqual(self.calc.divide(-1, -1), 1)
        self.assertEqual(self.calc.divide(-1, 1), -1)
        with self.assertRaises(ValueError):
            self.calc.divide(1, 0)
    
    def test_square(self):
        self.assertEqual(self.calc.square(2), 4)
        self.assertEqual(self.calc.square(-3), 9)
        self.assertEqual(self.calc.square(0), 0)

if __name__ == '__main__':
    unittest.main()

defmodule Grades.CalculatorTest do
  use ExUnit.Case

  alias Grades.Calculator

  test "letter_grade/1 returns a placeholder letter grade" do
    assert Calculator.letter_grade(100) == "A"
  end

  test "numeric_grade/1 returns a placeholder numeric grade" do
    assert Calculator.numeric_grade(100) == 90
  end

  test "percentage_grade/1 returns a placeholder percentage grade" do
    assert Calculator.percentage_grade(100) == 0.9
  end
end

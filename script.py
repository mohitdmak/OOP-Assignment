start = "Map<Square, javax.swing.JLabel> gui_squares_api = new HashMap<Square, javax.swing.JLabel>(){{\n"
meat = ""
end = "}};"
for i in range(0, 10):
    for j in range(0, 10):
        gui_button = "jl" + str(i) + str(j)
        action = "    put(all_squares[{i}][{j}], {gui_button});\n".format(i = i, j = j, gui_button = gui_button)
        meat += action
        print(gui_button)
    print("jl" + str(i) + "A")
    gui_button = "jl" + str(i) + "A"
    action = "    put(all_squares[{i}][10], {gui_button});\n".format(i = i, gui_button = gui_button)
    meat += action
    print("jl" + str(i) + "B")
    gui_button = "jl" + str(i) + "B"
    action = "    put(all_squares[{i}][11], {gui_button});\n".format(i = i, gui_button = gui_button)
    meat += action

# for A
for j in range(0, 10):
    gui_button = "jl" + "A" + str(j)
    action = "    put(all_squares[10][{j}], {gui_button});\n".format(j = j, gui_button = gui_button)
    meat += action
    print(gui_button)
        # put(all_squares[i]);
gui_button = "jl" + "A" + "A"
action = "    put(all_squares[10][10], {gui_button});\n".format(gui_button = gui_button)
meat += action
print(gui_button)
gui_button = "jl" + "A" + "B"
action = "    put(all_squares[10][11], {gui_button});\n".format(gui_button = gui_button)
meat += action
print(gui_button)

# for B
for j in range(0, 10):
    gui_button = "jl" + "B" + str(j)
    action = "    put(all_squares[11][{j}], {gui_button});\n".format(j = j, gui_button = gui_button)
    meat += action
    print(gui_button)
        # put(all_squares[i]);
gui_button = "jl" + "B" + "A"
action = "    put(all_squares[11][10], {gui_button});\n".format(gui_button = gui_button)
meat += action
print(gui_button)
gui_button = "jl" + "B" + "B"
action = "    put(all_squares[11][11], {gui_button});\n".format(gui_button = gui_button)
meat += action
print(gui_button)

print("\n FUNCTION \n")
print(start + meat + end)

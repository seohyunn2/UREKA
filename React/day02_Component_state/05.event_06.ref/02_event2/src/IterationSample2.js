import React, { Component } from "react";

export default class IterationSample2 extends Component {
  state = {
    names: [
      { id: 1, text: "눈사람" },
      { id: 2, text: "얼음" },
      { id: 3, text: "바람" },
      { id: 4, text: "봄" },
    ],
    inputText: "",
    nextId: 5,
  };

  handleRemove = (id) => {
    const { names } = this.state;
    const newNameList = names.filter((name) => name.id !== id);
    this.setState({ names: newNameList });
  };

  handleClick = () => {
    const { names, inputText, nextId } = this.state;
    const newNames = names.concat({ id: nextId, text: inputText });
    this.setState({
      names: newNames,
      inputText: "",
      nextId: nextId + 1,
    });
  };

  handleChange = (e) => {
    this.setState({ inputText: e.target.value });
  };

  render() {
    const { names, inputText } = this.state;
    const nameList = names.map((name) => (
      <li key={name.id} onClick={() => this.handleRemove(name.id)}>
        {name.text}
      </li>
    ));

    return (
      <div>
        <input type="text" value={inputText} onChange={this.handleChange} />
        <button onClick={this.handleClick}>추가</button>
        <ul>{nameList}</ul>
      </div>
    );
  }
}

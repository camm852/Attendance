import React from "react";
import { InputHTMLAttributes } from "react";

const InputForm = (props: InputHTMLAttributes<HTMLInputElement>) => {
  return <input className="" {...props} />;
};

export default InputForm;

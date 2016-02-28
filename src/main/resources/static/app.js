'use strict';

const React = require('react');
const UserList = require('./users');
const PostList = require('./posts');

React.render(
	<div>
		<div className="element">
			<PostList />
		</div>
		<div className="element">
			<UserList />
		</div>
	</div>,
	document.getElementById('react')
)

